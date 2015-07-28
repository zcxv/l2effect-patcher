class 5081 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect56
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.850000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.s_u804_c_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect57
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.p_u004_a'
	End Object
	Desc="NPC blow silence physical" //NPC blow silence physical
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect56',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect57',SpecificStage=0)
}