class 1036 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect16
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.wh_heal_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect17
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_magic_barrier_ta'
	End Object
	Desc="매직 배리어" //Magic Barrier
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect16',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect17',SpecificStage=0)
}