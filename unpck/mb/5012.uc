class 5012 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_LA
		SpawnDelay=1.000000
		offset=(X=1.000000,Y=0.000000,Z=0.500000)
		EffectClass=Class'LineageEffect.mb_frintessa_ghost_drain'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect14
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mb_frintessa_ghost_clamp_to'
	End Object
	Desc="PC묶기" //PC Bundling
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect14',SpecificStage=0)
}