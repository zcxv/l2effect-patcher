class 5004 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		offset=(X=0.000000,Y=0.000000,Z=20.000000)
		EffectClass=Class'LineageEffect.mb_frintessa_portal_a'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect27
		offset=(X=0.000000,Y=0.000000,Z=-2.000000)
		EffectClass=Class'LineageEffect.mb_frintessa_portal_b'
	End Object
	Desc="악마등장" //Devil appeared
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect27',SpecificStage=0)
}